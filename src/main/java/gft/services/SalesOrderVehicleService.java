package gft.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.CarPartQuantity;
import gft.entities.SalesOrderVehicle;
import gft.entities.Stock;
import gft.entities.Vehicle;
import gft.repositories.SalesOrderVehicleRepository;

@Service
public class SalesOrderVehicleService {
	
	@Autowired
	private SalesOrderVehicleRepository salesOrderRepository;
	@Autowired
	private StockService stockService;
	
	public SalesOrderVehicle saveSalesOrder (SalesOrderVehicle salesOrder) {
		return salesOrderRepository.save(salesOrder);
	}
	
	public Page<SalesOrderVehicle> listAllSalesOrder(Pageable pageable){
		return salesOrderRepository.findAll(pageable);
		
	}
	
	public SalesOrderVehicle findSalesOrderById(Long id) {
		Optional<SalesOrderVehicle> optional = salesOrderRepository.findById(id);
		return optional.orElseThrow(()-> new EntityNotFoundException("Sales Order não encontrada"));
	}
	
	public void deleteSalesOrder (Long id) {
		SalesOrderVehicle salesOrder = this.findSalesOrderById(id);
		salesOrderRepository.delete(salesOrder);
		
	}
	
	public SalesOrderVehicle updateSalesOrder (SalesOrderVehicle salesOrder, Long id) {
		SalesOrderVehicle originalSalesOrder = this.findSalesOrderById(id);
		salesOrder.setId(originalSalesOrder.getId());
		return salesOrderRepository.save(salesOrder);
	}

	public void verifyStockToSale(Vehicle vehicle) {
		int quantity;
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		for(CarPartQuantity carPartQuantity: vehicle.getCarPartsQuantity()) {
			quantity = carPartQuantity.getQuantity();
			stocks.addAll(stockService.saleCarPart(carPartQuantity.getCarPart(), quantity));
		}
		stockService.saveStocks(stocks);
	}
	

}
