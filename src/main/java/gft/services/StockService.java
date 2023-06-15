package gft.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.dtos.stock.StockCarPartDTO;
import gft.entities.CarPart;
import gft.entities.Stock;
import gft.exceptions.QuantityUnavailableException;
//import gft.exceptions.EntityNotFoundException;
import gft.repositories.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	public Stock saveStock(Stock stock) {
		return this.stockRepository.save(stock);
	}
	public List<Stock> saveStocks(List<Stock> stocks) {
		return this.stockRepository.saveAll(stocks);
	}
	
	public Page<Stock> listAllStocks(Pageable pageable){
		
		return stockRepository.findAll(pageable);
	}

	public Stock findStock(Long id) {
		Optional<Stock> optional = stockRepository.findById(id);
		//return optional.orElseThrow(() -> new EntityNotFoundException("Estoque não encontrado"));	
		return optional.get();
	}
	
	public Stock updateStock(Stock stock, Long id) {
		Stock stockOriginal = this.findStock(id);
		
		stock.setId(stockOriginal.getId());
		return stockRepository.save(stock);
	}

	public void deleteStock(Long id) {
		Stock stockOriginal = this.findStock(id);
		stockRepository.delete(stockOriginal);
	}
	
	public List<Stock> saleCarPart(CarPart carPart, int qtd) {
		List<Stock> stocks = stockRepository.findByCarPartId(carPart.getId());
		ArrayList<Stock> stocksUpdate = new ArrayList<Stock>();
		Integer quantity = qtd;
		for(Stock stock : stocks) {
			Integer quantityStock = stock.getQuantity();
			
			if(quantityStock> quantity) {
				stock.setQuantity(quantityStock-quantity);
				quantity=0;
				stocksUpdate.add(stock);
			}
			else if(quantityStock==quantity) {
				stock.setQuantity(0);
				quantity=0;
				stocksUpdate.add(stock);
			}
			else {
				stock.setQuantity(0);
				quantity = quantity-quantityStock;
				stocksUpdate.add(stock);
			}
			if(quantity==0) {
				//stockRepository.saveAll(stocksUpdate);
				return stocksUpdate;
			}
		}
		throw new QuantityUnavailableException("Peças indisponíveis.");
	}
	public StockCarPartDTO findStockCarPart(CarPart carPart) {
		
		List<Stock> stocks = stockRepository.findByCarPartId(carPart.getId());
		
		return calculateStock(stocks);
	}
	public StockCarPartDTO findStockTotal() {
	
		List<Stock> stocks = stockRepository.findAll();
		
		return calculateStock(stocks);
	}
	public StockCarPartDTO calculateStock(List<Stock> stocks) {
		StockCarPartDTO stockCarPartDTO= new StockCarPartDTO();
		int quantity=0;
		BigDecimal cost= new BigDecimal(0), price=new BigDecimal(0);
		for(Stock stock : stocks) {
			quantity+=stock.getQuantity();
			cost = cost.add(stock.getCost().multiply(new BigDecimal(quantity)));
			price = price.add(stock.getPrice().multiply(new BigDecimal(quantity)));
		}
		stockCarPartDTO.setQuantity(quantity);
		stockCarPartDTO.setCost(cost.setScale(2, RoundingMode.HALF_EVEN));
		stockCarPartDTO.setTotalValue(price.setScale(2, RoundingMode.HALF_EVEN));
		return stockCarPartDTO;
	}
	public BigDecimal findStockCarPartValue(CarPart carPart) {
		
		List<Stock> stocks = stockRepository.findByCarPartId(carPart.getId());
		
		return stocks.get(0).getCost();
	}
}
