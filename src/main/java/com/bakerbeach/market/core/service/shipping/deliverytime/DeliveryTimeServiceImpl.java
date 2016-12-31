package com.bakerbeach.market.core.service.shipping.deliverytime;

import com.bakerbeach.market.catalog.service.DeliveryTimeService;

public class DeliveryTimeServiceImpl implements DeliveryTimeService {

	private String leadingLocation = "USTER";
	private Integer continuesBackorderTime = 4;
	private DeliveryCalculator deliveryCalculator;

//	@Override
//	public DeliveryTime getDeliveryTime(SimpleProduct product) {
//		DeliveryTimeImpl deliveryTime = new DeliveryTimeImpl();
//		if (product != null) {
//			InventoryStatus inventory = product.getInventoryStatus();
//			if (product.isAvailable()) {
//				/*@todo
//					windelbar deal, outlet, split delivery option
//					windelbar delivery time span, not a single date
//				 */
//				if(product.get("wb_deal_active") != null && (Boolean)product.get("wb_deal_active")) {
//					deliveryTime.setDeliveryTimeText(new Text("product.backorderTime.deal", 14,21));
//					deliveryTime.setDeliveryDate(deliveryCalculator.getNextDeliveryDate(new Date(), 14));
//				}else if (inventory != null) {
//					if (inventory.getDiscreteStock() != null) {
//						if (inventory.getDiscreteStock().containsKey(leadingLocation) && inventory.getDiscreteStock().get(leadingLocation) > 0) {
//							deliveryTime.setDeliveryTimeText(new Text("product.available"));
//							deliveryTime.setDeliveryDate(deliveryCalculator.getNextDeliveryDate(new Date()));
//						} else {
//							for (String location : inventory.getDiscreteStock().keySet()) {
//								if (!location.equals(leadingLocation)) {
//									if (inventory.getDiscreteStock().get(location) > 0) {
//										deliveryTime.setDeliveryTimeText(new Text("product.backorderTime", continuesBackorderTime, continuesBackorderTime + 2));
//										deliveryTime.setContinuesTime(true);
//										deliveryTime.setDeliveryDate(deliveryCalculator.getNextDeliveryDate(new Date(), continuesBackorderTime + 1));
//									}
//								}
//							}
//							if (!deliveryTime.isContinuesTime()) {
//								deliveryTime.setBackorderTime(true);
//								deliveryTime.setDeliveryTimeText(new Text("product.backorderTime", product.getBackorderTime(), product.getBackorderTime() + 2));
//								deliveryTime.setDeliveryDate(deliveryCalculator.getNextDeliveryDate(new Date(), product.getBackorderTime() + 1));
//							}
//						}
//					} else {
//						if(product.getStock() > 0 && product.getStock() > product.getInventoryStatus().getOutOfStockLimit()){
//							deliveryTime.setDeliveryTimeText(new Text("product.available"));
//							deliveryTime.setDeliveryDate(deliveryCalculator.getNextDeliveryDate(new Date()));
//						}else{
//							deliveryTime.setBackorderTime(true);
//							deliveryTime.setDeliveryTimeText(new Text("product.backorderTime", product.getBackorderTime(), product.getBackorderTime() + 2));
//							deliveryTime.setDeliveryDate(deliveryCalculator.getNextDeliveryDate(new Date(), product.getBackorderTime() + 1));
//						}
//					}
//				} else
//					deliveryTime.setDeliveryTimeText(new Text("product.unavailable"));
//			} else {
//				deliveryTime.setDeliveryTimeText(new Text("product.unavailable"));
//			}
//		}
//		return deliveryTime;
//	}

	public String getLeadingLocation() {
		return leadingLocation;
	}

	public void setLeadingLocation(String leadingLocation) {
		this.leadingLocation = leadingLocation;
	}

	public DeliveryCalculator getDeliveryCalculator() {
		return deliveryCalculator;
	}

	public void setDeliveryCalculator(DeliveryCalculator deliveryCalculator) {
		this.deliveryCalculator = deliveryCalculator;
	}

}
