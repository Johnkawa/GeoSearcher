
package personal.john.app;

import android.location.Location;

public class HotelInfo {
    public Location mLocation;

    public String mNo;

    public String mName;

    public String mKanaName;

    public String mInfomationUrl;

    public String mPlanListUrl;

    public String mLatitude;

    public String mLongitude;

    public String mTelephoneNo;

    public String mSpecial;

    public String mAddress1;

    public String mAddress2;
    
    public String mHotelMinCharge;
    
    public boolean mVacant;

    public float mDistance;

    public HotelInfo() {
        Location location = new Location("RakutenWebService");
        mLocation = location;
    }

    public HotelInfo(final Location location, final String name) {
        mLocation = location;
        mName = name;
    }
    
    public Location getLocation() {
        mLocation.setAltitude(0);
        mLocation.setLatitude(Location.convert(mLatitude));
        mLocation.setLongitude(Location.convert(mLongitude));
        return mLocation;
    }
    
    public String toString() {
        if (mLocation != null) {
            return new String("Name:" + mName + ",Location:" + mLocation.toString());
        } else {
            return new String("Name:" + mName + ",Location:nodata");
        }
    }
    
    public void setDistance(double mylat, double mylon, double destlat, double destlon) {
        float[] fDistance = new float[1];
        Location.distanceBetween(mylat, mylon, destlat, destlon, fDistance);
        mDistance = fDistance[0];
    }
}
