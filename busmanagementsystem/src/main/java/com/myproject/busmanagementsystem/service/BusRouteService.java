package com.myproject.busmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.busmanagementsystem.dao.BusRouteDao;
import com.myproject.busmanagementsystem.dto.BusRoute;

//indicate that a class holds business logic and is a service provider in the application's service layer.
@Service
public class BusRouteService {
	@Autowired
	private BusRouteDao busRouteDao;

	public BusRoute saveBusRoute(BusRoute busRoute) {
		return busRouteDao.saveBusRoute(busRoute);
	}

	public BusRoute updateBusRoute(BusRoute busRoute,int id) {
		BusRoute brBusRoute = busRouteDao.updateBusRoute(busRoute, id);
		if (brBusRoute != null) {
			return brBusRoute;
		} else {
			return null;
		}
	}

	public BusRoute deleteBusRoute(int id) {
		BusRoute busRoute= busRouteDao.deleteBusRoute(id);
		if (busRoute!=null) {
			return busRoute;
		}
		else {	
			return null;
		}
	}

	public BusRoute getBusRouteById(int id) {
		BusRoute busRoute= busRouteDao.getBusRouteById(id);
		if (busRoute!=null) {
			return busRoute;
		}
		else {
			return null;
		}
	}
}
