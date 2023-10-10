package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    private int id;
    private Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        setId(id);
        setJourney(journey);
        setCosts(costs);
    }


    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }


    @Override
    public Journey getJourney() {
        return journey;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }


    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * journey.calculateTravelCosts();
    }


    @Override
    public double getAdministrativeCosts() {
        return costs;
    }


    private void setCosts(double costs) {
        if (costs < 0) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.", costs));
        }
        this.costs = costs;

    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----\nDestination: %s\nPrice: %.2f\n", journey.getDestination(), calculatePrice());
    }

}
