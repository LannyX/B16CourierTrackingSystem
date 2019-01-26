package com.rjt.b16couriertrackingsystem.api.module;

import com.google.gson.annotations.SerializedName;

public class StatusResponse {
    @SerializedName("shipmentid")
    private String shipmentid;
    @SerializedName("shipmentstatus")
    private String shipmentstatus;
    @SerializedName("vendor")
    private String vendor;
    @SerializedName("packagename")
    private String packagename;
    @SerializedName("pickupaddress")
    private String pickupaddress;
    @SerializedName("deliveryaddress")
    private String deliveryaddress;
    @SerializedName("pickuptime")
    private String pickuptime;
    @SerializedName("deliverytime")
    private String deliverytime;

    public StatusResponse(String shipmentid, String shipmentstatus, String vendor, String packagename, String pickupaddress, String deliveryaddress, String pickuptime, String deliverytime) {
        this.shipmentid = shipmentid;
        this.shipmentstatus = shipmentstatus;
        this.vendor = vendor;
        this.packagename = packagename;
        this.pickupaddress = pickupaddress;
        this.deliveryaddress = deliveryaddress;
        this.pickuptime = pickuptime;
        this.deliverytime = deliverytime;
    }

    public String getShipmentid() {
        return shipmentid;
    }

    public void setShipmentid(String shipmentid) {
        this.shipmentid = shipmentid;
    }

    public String getShipmentstatus() {
        return shipmentstatus;
    }

    public void setShipmentstatus(String shipmentstatus) {
        this.shipmentstatus = shipmentstatus;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getPickupaddress() {
        return pickupaddress;
    }

    public void setPickupaddress(String pickupaddress) {
        this.pickupaddress = pickupaddress;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    public String getPickuptime() {
        return pickuptime;
    }

    public void setPickuptime(String pickuptime) {
        this.pickuptime = pickuptime;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

}
