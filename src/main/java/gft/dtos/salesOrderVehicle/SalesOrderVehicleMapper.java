package gft.dtos.salesOrderVehicle;

import gft.dtos.vehicle.VehicleMapper;
import gft.entities.Customer;
import gft.entities.SalesOrderVehicle;
import gft.entities.Seller;
import gft.entities.Vehicle;

public class SalesOrderVehicleMapper {

	public static SalesOrderVehicle dtoToEntity (SalesOrderRegistrationVehicleDTO dto, Vehicle vehicle,Customer customer,Seller seller) {
		return new SalesOrderVehicle(null,dto.getPrice(), dto.getDate(), vehicle,customer,seller);
	}
	
	public static SalesOrderQueryVehicleDTO entityToDto (SalesOrderVehicle salesOrder) {
		return new SalesOrderQueryVehicleDTO(salesOrder.getId(), salesOrder.getDate(),salesOrder.getPrice(), VehicleMapper.entityToDto(salesOrder.getVehicle()), salesOrder.getCustomer(), salesOrder.getSeller());
	}
	
	public static SalesOrderPriceVehicleDTO vehicleToSalesOrder(Vehicle vehicle) {
		return new SalesOrderPriceVehicleDTO(vehicle.getPrice(), vehicle.getModel());
	}
}
