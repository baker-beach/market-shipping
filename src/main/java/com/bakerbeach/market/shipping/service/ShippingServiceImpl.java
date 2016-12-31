package com.bakerbeach.market.shipping.service;

import com.bakerbeach.market.core.api.model.Cart;
import com.bakerbeach.market.core.api.model.Customer;
import com.bakerbeach.market.core.api.model.ShopContext;
import com.bakerbeach.market.shipping.api.model.ShippingContext;
import com.bakerbeach.market.shipping.api.model.ShippingInfo;
import com.bakerbeach.market.shipping.api.service.ShippingService;
import com.bakerbeach.market.shipping.api.service.ShippingServiceException;

public class ShippingServiceImpl implements ShippingService {

	@Override
	public ShippingInfo apply(ShippingContext shippingContext) throws ShippingServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShippingContext createShippingContext(ShopContext shopContext, Customer customer, Cart cart)
			throws ShippingServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkShippingContext(ShopContext shopContext, ShippingContext shippingContext)
			throws ShippingServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
