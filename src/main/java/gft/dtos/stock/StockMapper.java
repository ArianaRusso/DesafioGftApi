package gft.dtos.stock;

import gft.entities.CarPart;
import gft.entities.Stock;

public class StockMapper {
	
	public static Stock fromDTO(StockRegistrationDTO dto, CarPart carPart) {
		return new Stock(null, carPart, dto.getCost(), dto.getPrice(), dto.getQuantity());
	}
	
	public static StockQueryDTO fromEntity(Stock stock) {
		return new StockQueryDTO(stock.getId(), stock.getCarPart(), stock.getCost(), stock.getPrice(), stock.getQuantity());
	}
}
