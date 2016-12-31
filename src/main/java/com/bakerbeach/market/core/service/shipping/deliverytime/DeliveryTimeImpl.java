package com.bakerbeach.market.core.service.shipping.deliverytime;

import java.util.Date;

import com.bakerbeach.market.core.api.model.DeliveryTime;
import com.bakerbeach.market.core.api.model.Text;

public class DeliveryTimeImpl implements DeliveryTime {
	
	private Text deliveryTimeText;
	private Date deliveryDate;
	private boolean backorderTime = false;
	private boolean continuesTime = false;

	@Override
	public Text getDeliveryTimeText() {
		return deliveryTimeText;
	}
	
	public void setDeliveryTimeText(Text deliveryTimeText){
		this.deliveryTimeText = deliveryTimeText;
	}

	@Override
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(Date deliveryDate){
		this.deliveryDate = deliveryDate;
	}

	@Override
	public Boolean isBackorderTime() {
		return backorderTime;
	}
	
	public void setBackorderTime(Boolean backorderTime){
		this.backorderTime = backorderTime;
	}

	@Override
	public Boolean isContinuesTime() {
		return continuesTime;
	}
	
	public void setContinuesTime(Boolean continuesTime) {
		this.continuesTime = continuesTime;
	}
	


}
