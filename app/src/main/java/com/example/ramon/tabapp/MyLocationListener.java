package com.example.ramon.tabapp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by Pichau on 12/02/2017.
 */

public class MyLocationListener implements LocationListener {
    private boolean ativo = false;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public void onLocationChanged(Location location) {
        setAtivo(true);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
