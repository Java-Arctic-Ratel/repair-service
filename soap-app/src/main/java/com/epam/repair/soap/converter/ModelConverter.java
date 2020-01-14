package com.epam.repair.soap.converter;

import com.epam.repairorder.*;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

@Component
public class ModelConverter {

    public RepairOrder convertToCategoryForSoap(com.epam.repair.model.RepairOrder entityRepairOrder) {
        RepairOrder repairOrder = new RepairOrder();
        repairOrder.setRepairOrderId(entityRepairOrder.getRepairOrderId());
        repairOrder.setRepairOrderStartDate(calendarConverter(entityRepairOrder.getRepairOrderStartDate()));
        repairOrder.setRepairOrderEndDate(calendarConverter(entityRepairOrder.getRepairOrderEndDate()));
        repairOrder.setClient(clientConverter(entityRepairOrder.getClient()));
        repairOrder.setDevice(deviceConverter(entityRepairOrder.getDevice()));
        repairOrder.setEmployee(employeeConverter(entityRepairOrder.getEmployee()));
        repairOrder.setSparePart(sparePartConverter(entityRepairOrder.getSparePart()));
        repairOrder.setStatus(statusConverter(entityRepairOrder.getStatus()));
        return repairOrder;
    }

    private XMLGregorianCalendar calendarConverter(LocalDate localDate) {
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newDefaultInstance().newXMLGregorianCalendar();
        xmlGregorianCalendar.setYear(localDate.getYear());
        xmlGregorianCalendar.setMonth(localDate.getMonthValue());
        xmlGregorianCalendar.setDay(localDate.getDayOfMonth());
        return xmlGregorianCalendar;
    }

    private Client clientConverter(com.epam.repair.model.Client entityClient) {
        Client client = new Client();
        client.setClientId(entityClient.getClientId());
        client.setClientPhoneNumber(entityClient.getClientPhoneNumber());
        client.setFirstName(entityClient.getFirstName());
        client.setLastName(entityClient.getLastName());
        client.setAddress(addressConverter(entityClient.getAddress()));
        return client;
    }

    private Address addressConverter(com.epam.repair.model.Address entityAddress) {
        Address address = new Address();
        address.setAddressId(entityAddress.getAddressId());
        address.setApartmentNumber(entityAddress.getApartmentNumber());
        address.setHouseNumber(entityAddress.getHouseNumber());
        address.setCity(cityConverter(entityAddress.getCity()));
        address.setStreet(streetConverter(entityAddress.getStreet()));
        return address;
    }

    private City cityConverter(com.epam.repair.model.City entityCity) {
        City city = new City();
        city.setCityId(entityCity.getCityId());
        city.setCityName(entityCity.getCityName());
        return city;
    }

    private Street streetConverter(com.epam.repair.model.Street entityStreet) {
        Street street = new Street();
        street.setStreetId(entityStreet.getStreetId());
        street.setStreetName(entityStreet.getStreetName());
        return street;
    }

    private Device deviceConverter(com.epam.repair.model.Device entityDevice) {
        Device device = new Device();
        device.setDeviceId(entityDevice.getDeviceId());
        device.setDeviceIMEIOrSn(entityDevice.getDeviceIMEIOrSn());
        device.setDevicePassword(entityDevice.getDevicePassword());
        device.setType(typeConverter(entityDevice.getType()));
        device.setBrand(brandConverter(entityDevice.getBrand()));
        device.setAppearance(appearanceConverter(entityDevice.getAppearance()));
        device.setComplectation(complectationConverter(entityDevice.getComplectation()));
        device.setModel(modelConverter(entityDevice.getModel()));
        device.setDefect(defectConverter(entityDevice.getDefect()));
        return device;
    }

    private Type typeConverter(com.epam.repair.model.Type entityType) {
        Type type = new Type();
        type.setTypeId(entityType.getTypeId());
        type.setTypeName(entityType.getTypeName());
        return type;
    }

    private Brand brandConverter(com.epam.repair.model.Brand entityBrand) {
        Brand brand = new Brand();
        brand.setBrandId(entityBrand.getBrandId());
        brand.setBrandName(entityBrand.getBrandName());
        return brand;
    }

    private Appearance appearanceConverter(com.epam.repair.model.Appearance entityAppearance) {
        Appearance appearance = new Appearance();
        appearance.setAppearanceId(entityAppearance.getAppearanceId());
        appearance.setAppearanceName(entityAppearance.getAppearanceName());
        return appearance;
    }

    private Complectation complectationConverter(com.epam.repair.model.Complectation entityComplectation) {
        Complectation complectation = new Complectation();
        complectation.setComplectationId(entityComplectation.getComplectationId());
        complectation.setComplectationName(entityComplectation.getComplectationName());
        return complectation;
    }

    private Model modelConverter(com.epam.repair.model.Model entityModel) {
        Model model = new Model();
        model.setModelId(entityModel.getModelId());
        model.setModelName(entityModel.getModelName());
        return model;
    }

    private Defect defectConverter(com.epam.repair.model.Defect entityDefect) {
        Defect defect = new Defect();
        defect.setDefectId(entityDefect.getDefectId());
        defect.setDefectName(entityDefect.getDefectName());
        return defect;
    }

    private Employee employeeConverter(com.epam.repair.model.Employee entityEmployee) {
        Employee employee = new Employee();
        employee.setEmployeeId(entityEmployee.getEmployeeId());
        employee.setFirstName(entityEmployee.getFirstName());
        employee.setLastName(entityEmployee.getLastName());
        employee.setEmployeeType(employeeTypeConverter(entityEmployee.getEmployeeType()));
        return employee;
    }

    private EmployeeType employeeTypeConverter(com.epam.repair.model.EmployeeType entityEmployeeType) {
        EmployeeType employeeType = new EmployeeType();
        employeeType.setEmployeeTypeId(entityEmployeeType.getEmployeeTypeId());
        employeeType.setEmployeeTypeName(entityEmployeeType.getEmployeeTypeName());
        return employeeType;
    }

    private SparePart sparePartConverter(com.epam.repair.model.SparePart entitySparePart) {
        SparePart sparePart = new SparePart();
        sparePart.setSparePartId(entitySparePart.getSparePartId());
        sparePart.setSparePartCost(entitySparePart.getsparePartCost());
        sparePart.setSparePartName(entitySparePart.getSparePartName());
        return sparePart;
    }

    Status statusConverter(com.epam.repair.model.Status entityStatus) {
        Status status = new Status();
        status.setStatusId(entityStatus.getStatusId());
        status.setStatusName(entityStatus.getStatusName());
        return status;
    }
}
