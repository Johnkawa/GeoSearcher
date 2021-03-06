
package personal.john.app;

import java.util.Comparator;

public class MyComparator implements Comparator<HotelInfo> {
    public static final int ASC = 1; // 昇順

    public static final int DESC = -1; // 降順

    public static final int MODE_HOTELNAME = 1; // ホテル名でソート

    public static final int MODE_DISTANCE = 2; // 距離でソート

    public static final int MODE_MINCHARGE = 3; // 価格でソート

    public static final int MODE_VACANT = 4; // 空き部屋でソート

    private int sort;

    private int mode;

    public MyComparator() {
        sort = ASC;
        mode = MODE_HOTELNAME;
    }

    public MyComparator(int sort, int mode) {
        this.sort = sort;
        this.mode = mode;
    }

    @Override
    public int compare(HotelInfo lhs, HotelInfo rhs) {
        if (lhs == null && rhs == null) {
            return 0; // arg0 = arg1
        } else if (lhs == null) {
            return 1 * sort; // arg1 > arg2
        } else if (rhs == null) {
            return -1 * sort; // arg1 < arg2
        }

        switch (mode) {
            case MODE_HOTELNAME:
                return ((Comparable) lhs.mName).compareTo((Comparable) rhs.mName) * sort;
            case MODE_DISTANCE:
                return ((Comparable) lhs.mDistance).compareTo((Comparable) rhs.mDistance)
                        * sort;
            case MODE_MINCHARGE:
                return ((Comparable) lhs.mHotelMinCharge).compareTo((Comparable) rhs
                        .mHotelMinCharge) * sort;
            case MODE_VACANT:
                return ((Comparable) lhs.mVacant).compareTo((Comparable) rhs.mVacant)
                        * sort;
            default:
                return ((Comparable) lhs.mName).compareTo((Comparable) rhs.mName) * sort;
        }
    }
}
