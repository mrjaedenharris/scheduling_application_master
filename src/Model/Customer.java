package Model;

import java.sql.*;
import Model.Database;
import Model.City;
import Model.Address;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {

    static private ObservableList<Customer> data = FXCollections.observableArrayList();
    static private ObservableList<String> customerNames = FXCollections.observableArrayList();
    static private Customer modifiableCustomer = null;

    private SimpleStringProperty customerName;
    private Address customerAddress;
    private City customerCity;
    private Country customerCountry;
    private SimpleIntegerProperty addressId;
    private ObservableList<Appointment> customerAppointments = FXCollections.observableArrayList();
    private SimpleIntegerProperty customerId;


    public Customer(String userName, String userPhone, String userAddress, String userCity, String userPostal, String userCountry) {
        this.customerAddress = new Address(userAddress, userPostal, userPhone);
        this.customerCity = new City(userCity);
        this.customerCountry = new Country(userCountry);
        this.customerName = new SimpleStringProperty(userName);
    }

    public Customer(String userName, String userPhone, String userAddress, String userCity, String userPostal, String userCountry, int addressId) {
        this.customerAddress = new Address(userAddress, userPostal, userPhone);
        this.customerCity = new City(userCity);
        this.customerCountry = new Country(userCountry);
        this.customerName = new SimpleStringProperty(userName);
        this.addressId = new SimpleIntegerProperty(addressId);
    }

    public Customer(String userName, City newCity, Address newAddress) {
        this.customerName = new SimpleStringProperty(userName);
        this.customerAddress = newAddress;
        this.customerCity = newCity;
    }

    public Customer(String userName,Country newCountry, City newCity, Address newAddress, int addressId) {
        this.customerCountry = newCountry;
        this.customerName = new SimpleStringProperty(userName);
        this.customerAddress = newAddress;
        this.customerCity = newCity;
        this.addressId = new SimpleIntegerProperty(addressId);
    }


    public Customer() {

        this.customerName = new SimpleStringProperty();
        this.customerAddress = new Address();
        this.customerCity = new City();
        this.customerCountry = new Country();
        this.addressId = new SimpleIntegerProperty();

    }

    public static ObservableList<String> getCustomerNames() {
        return customerNames;
    }

    public static Customer getModifiableCustomer() {
        return modifiableCustomer;
    }

    public static void setModifiableCustomer(Customer modifiableCustomer) {
        Customer.modifiableCustomer = modifiableCustomer;
    }

    public static ObservableList<Customer> getData()
    {
        return data;
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public SimpleStringProperty customerNameProperty()
    {
        return customerName;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public City getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(City customerCity) {
        this.customerCity = customerCity;
    }

    public Country getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(Country customerCountry) {
        this.customerCountry = customerCountry;
    }

    public void setAddress(String newAddress) {
        this.getCustomerAddress().setAddress(newAddress);
    }

    public String getAddress() {
        return this.getCustomerAddress().getAddress();
    }

    public int getAddressId() {
        return addressId.get();
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.getCustomerAddress().setPhoneNumber(newPhoneNumber);
    }

    public String getPhoneNumber() {
        return this.getCustomerAddress().getPhoneNumber();
    }

    public void setCity(String newCity) {
        this.getCustomerCity().setCity(newCity);
    }

    public String getCity() {
        return this.getCustomerCity().getCity();
    }

    public void setPostalCode(String newPostalCode)
    {
        this.getCustomerAddress().setPostalCode(newPostalCode);
    }

    public String getPostalCode() {
        return this.getCustomerAddress().getPostalCode();
    }

    public void setCountry(String newCountry) {this.getCustomerCountry().setCountry(newCountry);}

    public String getCountry () {return this.getCustomerCountry().getCountry();}

    public int getCustomerId() {
        return customerId.get();
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public SimpleIntegerProperty customerIdProperty() {
        return customerId;
    }

    public static boolean isNumeric (String str) {

        try {

            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static void main(String[] args) {

        Customer jaeden = new Customer("Jaeden", "4359944440", "1172 W 3 pt", "Logan", "84341", "USA");

        jaeden.getCustomerName();

        //(String userName, String userPhone, String userAddress, String userCity, String userPostal, String userCountry)

    }


}

