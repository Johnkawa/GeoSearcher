
package personal.john.app.rakutenclient;

import java.util.ArrayList;

import personal.john.app.HotelInfo;

public interface RakutenClientReceiver {
    public void onReceiveHotel(ArrayList<HotelInfo> infoList);

    public void onReceiveError(int id);
}
