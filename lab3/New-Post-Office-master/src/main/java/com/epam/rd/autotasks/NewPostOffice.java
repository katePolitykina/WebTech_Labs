package com.epam.rd.autotasks;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {
    private final Collection<Box> listBox;
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    // implements student
    public boolean addBox(String addresser, String recipient, double weight, double volume, int value) {
        if (addresser==null || recipient == null|| addresser.trim().isEmpty() || recipient.trim().isEmpty() || weight < 0.5
            || weight > 20 || volume <=0 || volume>0.25 || value<=0)
            throw new IllegalArgumentException();
        BigDecimal cost = calculateCostOfBox(weight, volume, value);
        Box box = new Box(addresser, recipient, weight, volume);
        box.setCost(cost);

        return listBox.add(box);
    }

    // implements student
    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        ArrayList<Box> arrayList = new ArrayList<>();

        Iterator<Box> iterator = listBox.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getRecipient().equals(recipient)) {
                arrayList.add(box);
                iterator.remove();
            }
        }
        return arrayList;
    }

    public void declineCostOfBox(double percent) {
        Iterator<Box> iterator = listBox.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            box.setCost(box.getCost().multiply(BigDecimal.valueOf(1 - (percent/100.0)), MathContext.DECIMAL64));
        }
    }

}
