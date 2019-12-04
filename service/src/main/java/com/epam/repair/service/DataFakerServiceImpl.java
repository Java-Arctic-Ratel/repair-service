package com.epam.repair.service;

import com.epam.repair.dao.*;
import com.epam.repair.model.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Data Faker Service Interface implementation.
 */
@Service
@Transactional
public class DataFakerServiceImpl implements DataFakerService {

    private Locale locale = new Locale("ru");
    private Faker faker = new Faker(locale);
    private int STREETS_QUANTITY = 50;
    private int CITIES_QUANTITY = 50;
    private int ADDRESSES_QUANTITY = 100;
    private int EMPLOYEE_TYPES_QUANTITY = 5;
    private int EMPLOYEE_QUANTITY = 5;
    private int COMPLECTATIONS_QUANTITY = 10;
    private int CLIENTS_QUANTITY = 100;
    private int DEFECTS_QUANTITY = 10;
    private int APPEARANCES_QUANTITY = 10;
    private int BRANDS_QUANTITY = 10;
    private int MODELS_QUANTITY = 10;
    private int TYPES_QUANTITY = 10;
    private int DEVICES_QUANTITY = 100;
    private int SPAREPARTS_QUANTITY = 100;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private StreetDao streetDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private EmployeeTypeDao employeeTypeDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ComplectationDao complectationDao;

    @Autowired
    private DefectDao defectDao;

    @Autowired
    private AppearanceDao appearanceDao;

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private ModelDao modelDao;

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private SparePartDao sparePartDao;

    @Autowired
    private StatusDao statusDao;

    @Autowired
    private RepairOrderDao repairOrderDao;

    /**
     * Instantiates a new Data faker service.
     *
     * @param repairOrderService the repair order service
     */
    public DataFakerServiceImpl(RepairOrderService repairOrderService) {
        this.repairOrderService = repairOrderService;
    }

    @Override
    public void startCreation(Integer numberOfOrders) {
        repairOrderService.deleteAll();
        createStreets();
        createCities();
        createAddresses();
        createClients();
        createEmployeesTypes();
        createEmployees();
        createComplectation();
        createDefects();
        createAppearances();
        createBrands();
        createModels();
        createTypes();
        createDevices();
        createSpareParts();
        createStatuses();
        createOrders(numberOfOrders);
    }

    @Override
    public void createStreets() {
        Street street = new Street();
        for (int i = 1; i <= STREETS_QUANTITY; i++) {
            street.setStreetId(i);
            street.setStreetName(faker.address().streetName());
            streetDao.saveAndFlush(street);
        }
    }

    @Override
    public void createCities() {
        City city = new City();
        for (int i = 1; i <= CITIES_QUANTITY; i++) {
            city.setCityId(i);
            city.setCityName(faker.address().cityName());
            cityDao.saveAndFlush(city);
        }
    }

    @Override
    public void createAddresses() {
        Address address = new Address();
        for (int i = 1; i <= ADDRESSES_QUANTITY; i++) {
            address.setAddressId(i);
            address.setHouseNumber(faker.address().buildingNumber());
            address.setApartmentNumber(faker.address().buildingNumber());
            address.setCity(cityDao.getOne(createRandomId(CITIES_QUANTITY)));
            address.setStreet(streetDao.getOne(createRandomId(STREETS_QUANTITY)));
            addressDao.saveAndFlush(address);
        }
    }

    @Override
    public void createClients() {
        for (int i = 1; i <= CLIENTS_QUANTITY; i++) {
            Client client = new Client();
            client.setClientId(i);
            client.setClientPhoneNumber(faker.phoneNumber().subscriberNumber(12));
            client.setFirstName(faker.name().firstName());
            client.setLastName(faker.name().lastName());
            client.setAddress(addressDao.getOne(createRandomId(ADDRESSES_QUANTITY)));
            clientDao.saveAndFlush(client);
        }
    }

    @Override
    public void createEmployeesTypes() {
        EmployeeType employeeType = new EmployeeType();
        for (int i = 1; i <= EMPLOYEE_TYPES_QUANTITY; i++) {
            employeeType.setEmployeeTypeId(i);
            employeeType.setEmployeeTypeName(faker.name().prefix());
            employeeTypeDao.saveAndFlush(employeeType);
        }
    }

    @Override
    public void createEmployees() {
        Employee employee = new Employee();
        for (int i = 1; i <= EMPLOYEE_QUANTITY; i++) {
            employee.setEmployeeId(i);
            employee.setFirstName(faker.name().firstName());
            employee.setLastName(faker.name().lastName());
            employee.setEmployeeType(employeeTypeDao.getOne(createRandomId(EMPLOYEE_TYPES_QUANTITY)));
            employeeDao.saveAndFlush(employee);
        }
    }

    @Override
    public void createComplectation() {
        Complectation complectation = new Complectation();
        for (int i = 1; i <= COMPLECTATIONS_QUANTITY; i++) {
            complectation.setComplectationId(i);
            complectation.setComplectationName(faker.food().fruit());
            complectationDao.saveAndFlush(complectation);
        }
    }

    @Override
    public void createDefects() {
        Defect defect = new Defect();
        for (int i = 1; i <= DEFECTS_QUANTITY; i++) {
            defect.setDefectId(i);
            defect.setDefectName(faker.food().fruit());
            defectDao.saveAndFlush(defect);
        }
    }

    @Override
    public void createAppearances() {
        Appearance appearance = new Appearance();
        for (int i = 1; i <= APPEARANCES_QUANTITY; i++) {
            appearance.setAppearanceId(i);
            appearance.setAppearanceName(faker.food().vegetable());
            appearanceDao.saveAndFlush(appearance);
        }
    }

    @Override
    public void createBrands() {
        Brand brand = new Brand();
        for (int i = 1; i <= BRANDS_QUANTITY; i++) {
            brand.setBrandId(i);
            brand.setBrandName(faker.food().vegetable());
            brandDao.saveAndFlush(brand);
        }
    }

    @Override
    public void createModels() {
        Model model = new Model();
        for (int i = 1; i <= MODELS_QUANTITY; i++) {
            model.setModelId(i);
            model.setModelName(faker.food().vegetable());
            modelDao.saveAndFlush(model);
        }
    }

    @Override
    public void createTypes() {
        Type type = new Type();
        for (int i = 1; i <= TYPES_QUANTITY; i++) {
            type.setTypeId(i);
            type.setTypeName(faker.food().vegetable());
            typeDao.saveAndFlush(type);
        }
    }

    @Override
    public void createDevices() {
        Device device = new Device();
        for (int i = 1; i <= DEVICES_QUANTITY; i++) {
            device.setDeviceId(i);
            device.setDeviceIMEIOrSn(faker.number().digits(14));
            device.setDevicePassword(faker.number().digits(4));
            device.setType(typeDao.getOne(createRandomId(TYPES_QUANTITY)));
            device.setModel(modelDao.getOne(createRandomId(MODELS_QUANTITY)));
            device.setBrand(brandDao.getOne(createRandomId(BRANDS_QUANTITY)));
            device.setAppearance(appearanceDao.getOne(createRandomId(APPEARANCES_QUANTITY)));
            device.setComplectation(complectationDao.getOne(createRandomId(COMPLECTATIONS_QUANTITY)));
            device.setDefect(defectDao.getOne(createRandomId(DEFECTS_QUANTITY)));
            deviceDao.saveAndFlush(device);
        }
    }

    @Override
    public void createSpareParts() {
        SparePart sparePart = new SparePart();
        for (int i = 1; i <= SPAREPARTS_QUANTITY; i++) {
            sparePart.setSparePartId(i);
            sparePart.setsparePartCost(BigDecimal.valueOf(faker.number().numberBetween(10, 100)));
            sparePart.setSparePartName(faker.funnyName().name());
            sparePartDao.saveAndFlush(sparePart);
        }
    }

    @Override
    public void createStatuses() {
        ArrayList<String> statuses = new ArrayList<>();
        statuses.add("In work");
        statuses.add("Ready");
        statuses.add("Waiting for a spare part");
        statuses.add("Issued");
        Status status = new Status();
        for (int i = 1; i <= statuses.size(); i++) {
            status.setStatusId(i);
            status.setStatusName(statuses.get(i - 1));
            statusDao.saveAndFlush(status);
        }
    }

    @Override
    public void createOrders(Integer numberOfOrders) {
        String stDate = "2019-01-01";
        String enDate = "2020-01-01";
        LocalDate startDate = LocalDate.parse(stDate);
        LocalDate endDate = LocalDate.parse(enDate);
        for (int i = 1; i <= numberOfOrders; i++) {
            RepairOrder repairOrder = new RepairOrder();
            repairOrder.setRepairOrderId(i);
            repairOrder.setRepairOrderStartDate(convertToLocalDateViaInstant(faker.date().between(convertToDateViaInstant(startDate), convertToDateViaInstant(endDate))));
            repairOrder.setRepairOrderEndDate(convertToLocalDateViaInstant(faker.date().between(convertToDateViaInstant(startDate), convertToDateViaInstant(endDate))));
            repairOrder.setRepairOrderIssueDate(convertToLocalDateViaInstant(faker.date().between(convertToDateViaInstant(startDate), convertToDateViaInstant(endDate))));
            repairOrder.setRepairOrderCostEstimated(BigDecimal.valueOf(faker.number().numberBetween(10, 100)));
            repairOrder.setRepairOrderCostTotal(BigDecimal.valueOf(faker.number().numberBetween(10, 100)));
            repairOrder.setClient(clientDao.getOne(createRandomId(CLIENTS_QUANTITY)));
            repairOrder.setDevice(deviceDao.getOne(createRandomId(DEVICES_QUANTITY)));
            repairOrder.setEmployee(employeeDao.getOne(createRandomId(EMPLOYEE_QUANTITY)));
            repairOrder.setSparePart(sparePartDao.getOne(createRandomId(SPAREPARTS_QUANTITY)));
            int STATUSES_QUANTITY = 4;
            repairOrder.setStatus(statusDao.getOne(createRandomId(STATUSES_QUANTITY)));
            repairOrderDao.save(repairOrder);
        }
    }

    private Integer createRandomId(int maxValue) {
        Random random = new Random();
        int minValue = 1;
        return random.nextInt(maxValue - minValue) + minValue;
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
