package com.tusaryan.aopApp.AopAppApplication.services;

public interface ShipmentService {
    String orderPackage(Long orderId);

    String trackPackage(Long orderId);
}
