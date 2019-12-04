package com.epam.repair.service;

/**
 * The interface Data Faker service.
 */
public interface DataFakerService {

    /**
     * @param numberOfOrders - quantity of necessary orders
     */
    void startCreation(Integer numberOfOrders);

    /**
     * Create fake Streets.
     */
    void createStreets();

    /**
     * Create fake Cities.
     */
    void createCities();

    /**
     * Create fake Addresses.
     */
    void createAddresses();

    /**
     * Create fake Clients.
     */
    void createClients();

    /**
     * Create fake Employees.
     */
    void createEmployees();

    /**
     * Create fake Employee Types.
     */
    void createEmployeesTypes();

    /**
     * Create fake Complectations.
     */
    void createComplectation();

    /**
     * Create fake Defects.
     */
    void createDefects();

    /**
     * Create fake Appearances.
     */
    void createAppearances();

    /**
     * Create fake Brands.
     */
    void createBrands();

    /**
     * Create fake Models.
     */
    void createModels();

    /**
     * Create fake Device Types.
     */
    void createTypes();

    /**
     * Create fake Devices.
     */
    void createDevices();

    /**
     * Create fake Spare parts.
     */
    void createSpareParts();

    /**
     * Create fake Statuses.
     */
    void createStatuses();

    /**
     * Create fake Orders.
     *
     * @param numberOfOrders - quantity of necessary orders
     */
    void createOrders(Integer numberOfOrders);
}
