package com.example.car_tax_management;

import com.example.car_tax_management.entites.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTaxManagementApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestRestTemplate restTemplate;


    private String GetURL(String... params){
        String url = "http://localhost:" + port;

        for (String p: params){
            url += "/" + p;
        }
        return url;
    }


    public String RetrieveAdminJwtToken() throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:8090/auth/realms/VehicleTaxManagementRealm/protocol/openid-connect/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "JSESSIONID=EA37A32E1060B7684C51EF2E082B4391.v0019481; JSESSIONID=406C6853E3769CF5E41C3912C1895528")
                .field("client_id", "tax-management")
                .field("username", "adminuser")
                .field("password", "123456")
                .field("grant_type", "password")
                .asString();
        String[] responseInfo = response.getBody().split("\"");
        String JwtAccessToken = responseInfo[3];
        return JwtAccessToken;
    }

    public String RetrieveBasicUserJwtToken() throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:8090/auth/realms/VehicleTaxManagementRealm/protocol/openid-connect/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "JSESSIONID=EA37A32E1060B7684C51EF2E082B4391.v0019481; JSESSIONID=406C6853E3769CF5E41C3912C1895528")
                .field("client_id", "tax-management")
                .field("username", "basicuser")
                .field("password", "123456")
                .field("grant_type", "password")
                .asString();
        String[] responseInfo = response.getBody().split("\"");
        String JwtAccessToken = responseInfo[3];
        return JwtAccessToken;
    }

    @Test
    public void TestIncorrectTypeAddressGet() throws IOException, UnirestException, URISyntaxException {

        URI uri = new URI ( GetURL ( "address","hello" ));
        Unirest.setTimeouts(0, 0);
        com.mashape.unirest.http.HttpResponse<String> response = Unirest.get(String.valueOf(uri))
                .header("Authorization", "Bearer "+RetrieveAdminJwtToken())
                .header("Content-Type", "application/json")
                .asString();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus());


    }

    @Test
    public void TestPostAuthenticationSuccessfulHttpCode() throws URISyntaxException, UnirestException {

        URI uri = new URI(GetURL("address"));

        Address address = new Address();
        address.setCountry("England");
        address.setCounty("Staines");
        address.setPostcode("TW197AF");
        address.setNameornumber("34");
        address.setStreet("Osborne Avenue");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveBasicUserJwtToken());

        HttpEntity<Address> request = new HttpEntity<>(address, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCodeValue());
    }

    @Test
    @Order(1)
    public void TestAddressTypePostSuccessfulHttpCode() throws URISyntaxException, UnirestException {

        URI uri = new URI(GetURL("address"));

        Address address = new Address();
        address.setCountry("England");
        address.setCounty("Staines");
        address.setPostcode("TW197AF");
        address.setNameornumber("34");
        address.setStreet("Osborne Avenue");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        HttpEntity<Address> request = new HttpEntity<>(address, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(2)
    public void TestOwnerTypePostSuccessfulHttpCode() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("owner"));

        Owner owner = new Owner();
        owner.setDob("1996-04-06");
        owner.setEmail("harry.jervis@gmail.com");
        owner.setFirstname("Harry");
        owner.setLastname("Jervis");
        owner.setPhonenumber("07735924714");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        HttpEntity<Owner> request = new HttpEntity<>(owner, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(3)
    public void TestCarTypePostSuccessfulHttpCode() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("car"));

        Car car = new Car();
        car.setFueltype("Petrol");
        car.setNumberplate("PY08KWU");
        car.setVehiclecolour("Blue");
        car.setVehiclemake("Honda");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        HttpEntity<Car> request = new HttpEntity<>(car, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void TestTaxInfoTypePostSuccessfulHttpCode() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("taxinfo"));

        TaxInfo taxInfo = new TaxInfo();
        taxInfo.setTaxduration(6);
        taxInfo.setTaxexpirydate("2021-10-21");
        taxInfo.setTaxstartdate("2021-04-21");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        HttpEntity<TaxInfo> request = new HttpEntity<>(taxInfo, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(5)
    public void TestSornTypePostSuccessfulHttpCode() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("sorn"));

        Sorn sorn = new Sorn();
        sorn.setSorndate("1998-01-01");
        sorn.setSornstatus(false);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        HttpEntity<Sorn> request = new HttpEntity<>(sorn, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(6)
    public void TestTaxPaymentTypePostSuccessfulHttpCode() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("taxpayment"));

        TaxPayment taxPayment = new TaxPayment();
        taxPayment.setAccountnumber("57683947");
        taxPayment.setCardnumber("1111222233334444");
        taxPayment.setInstallments(true);
        taxPayment.setSortcode("48-68-21");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        HttpEntity<TaxPayment> request = new HttpEntity<>(taxPayment, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCodeValue());
    }

    @Test
    @Order(7)
    public void TestAddressTypeGetSuccesfulData() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("address","1"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        ResponseEntity<Address> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Address.class);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCodeValue());
        Assert.assertEquals("England", response.getBody().getCountry());
        Assert.assertEquals("Staines", response.getBody().getCounty());
        Assert.assertEquals("TW197AF", response.getBody().getPostcode());
        Assert.assertEquals("34", response.getBody().getNameornumber());
        Assert.assertEquals("Osborne Avenue", response.getBody().getStreet());
    }

    @Test
    @Order(8)
    public void TestOwnerTypeGetSuccesfulData() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("owner","1"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        ResponseEntity<Owner> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Owner.class);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCodeValue());
        Assert.assertEquals(LocalDate.parse("1996-04-06"),response.getBody().getDob());
        Assert.assertEquals("harry.jervis@gmail.com",response.getBody().getEmail());
        Assert.assertEquals("Harry",response.getBody().getFirstname());
        Assert.assertEquals("Jervis",response.getBody().getLastname());
        Assert.assertEquals("07735924714",response.getBody().getPhonenumber());

    }

    @Test
    @Order(9)
    public void TestCarTypeGetSuccesfulData() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("car","1"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        ResponseEntity<Car> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Car.class);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCodeValue());
        Assert.assertEquals("Petrol",response.getBody().getFueltype());
        Assert.assertEquals("PY08KWU",response.getBody().getNumberplate());
        Assert.assertEquals("Blue",response.getBody().getVehiclecolour());
        Assert.assertEquals("Honda",response.getBody().getVehiclemake());

    }

    @Test
    @Order(10)
    public void TestTaxInfoTypeGetSuccesfulData() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("taxinfo","1"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        ResponseEntity<TaxInfo> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), TaxInfo.class);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCodeValue());
        Assert.assertEquals(6,response.getBody().getTaxduration());
        Assert.assertEquals(LocalDate.parse("2021-10-21"),response.getBody().getTaxexpirydate());
        Assert.assertEquals(LocalDate.parse("2021-04-21"),response.getBody().getTaxstartdate());
    }

    @Test
    @Order(11)
    public void TestSornGetSuccesfulData() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("sorn","1"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        ResponseEntity<Sorn> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Sorn.class);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCodeValue());
        Assert.assertEquals(LocalDate.parse("1998-01-01"), response.getBody().getSorndate());
        Assert.assertEquals(false, response.getBody().isSornstatus());
    }

    @Test
    @Order(12)
    public void TestTaxPaymentGetSuccesfulData() throws URISyntaxException, UnirestException {
        URI uri = new URI(GetURL("taxpayment","1"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");
        headers.add("Authorization", "Bearer "+RetrieveAdminJwtToken());

        ResponseEntity<TaxPayment> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), TaxPayment.class);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCodeValue());
        Assert.assertEquals("57683947",response.getBody().getAccountnumber());
        Assert.assertEquals("1111222233334444",response.getBody().getCardnumber());
        Assert.assertEquals(true,response.getBody().isInstallments());
        Assert.assertEquals("48-68-21",response.getBody().getSortcode());
    }
}
