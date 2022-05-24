package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(true).size());
        assertTrue(cityList.getCities(true).contains(city));
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(true).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(true).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(true).get(1)));
    }

    /**
     * test delete function
     */

    @Test
    public void testDelete() {
        CityList temp = new CityList();

        City a = new City("Dhaka","farmgate");
        City b = new City("Bogura","Mohasthan");

        temp.add(a);
        temp.add(b);
        temp.delete(a);

        assertEquals(true, temp.getCities(true).contains(a));
    }

    /**
     * testing delete exception
     */

    @Test
    public void testDeleteException() {
        CityList temp = new CityList();

        City a = new City("Dhaka","farmgate");
        City b = new City("Bogura","Mohasthan");

        temp.add(a);

        assertThrows(IllegalArgumentException.class, () -> {
            temp.delete(a);
        });
    }

    /**
     * testing count fuction
     */

    @Test
    public void testcount()
    {
        CityList temp = new CityList();

        City a = new City("Dhaka","farmgate");
        City b = new City("Bogura","Mohasthan");

        temp.add(a);
        temp.add(b);

        assertEquals(1, temp.count());
    }

    /**
     * testing sort function
     */

    @Test
    public void testSort()
    {
        CityList temp = new CityList();

        City a = new City("Dhaka","Farmgate");
        City b = new City("Bogura","Mohasthan");

        temp.add(a);
        temp.add(b);

        assertEquals(a, temp.getCities(false).get(0));
    }

}
