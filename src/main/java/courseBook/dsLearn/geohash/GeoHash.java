package courseBook.dsLearn.geohash;


public class GeoHash {
    private Point point;
    private static final int MAX_BIT_PRECISION = 64;
    protected byte significantBits = 0;
    protected long bits = 0;

    public long getBits() {
        return bits;
    }
    //最后+1
    protected final void addOnBitToEnd() {
        significantBits++;
        bits <<= 1;
        bits = bits | 0x1;
    }
    //最后+0
    protected final void addOffBitToEnd() {
        significantBits++;
        bits <<= 1;
    }
    private static final char[] base32 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    private void divideRangeEncode(double value, double[] range) {
        double mid = (range[0] + range[1]) / 2;
        if (value >= mid) {
            addOnBitToEnd();
            range[0] = mid;
        } else {
            addOffBitToEnd();
            range[1] = mid;
        }

    }
    private  BoundingBox boundingBox;
    private static void setBoundingBox(GeoHash hash, double[] latitudeRange, double[] longitudeRange) {
        hash.boundingBox = new BoundingBox(new Point(latitudeRange[0], longitudeRange[0]), new Point(
                latitudeRange[1],
                longitudeRange[1]));
    }
    //最多分割成64位
    private GeoHash(double latitude, double longitude, int strlen) {
        int desiredPrecision = (strlen * 5 <= 60) ? strlen * 5 : 60;
        point = new Point(latitude, longitude);
        desiredPrecision = Math.min(desiredPrecision, MAX_BIT_PRECISION);

        boolean isEvenBit = true;
        double[] latitudeRange = { -90, 90 };
        double[] longitudeRange = { -180, 180 };
        //偶数是经度
        while (significantBits < desiredPrecision) {
            if (isEvenBit) {
                divideRangeEncode(longitude, longitudeRange);
            } else {
                divideRangeEncode(latitude, latitudeRange);
            }
            isEvenBit = !isEvenBit;
//            System.out.println(Long.toBinaryString(bits));
        }

        setBoundingBox(this, latitudeRange, longitudeRange);
        //变成64位
        bits <<= (MAX_BIT_PRECISION - desiredPrecision);
    }
    public String toBase32() {
        if (significantBits % 5 != 0) {
            throw new IllegalStateException("Cannot convert a geohash to base32 if the precision is not a multiple of 5.");
        }
        StringBuilder buf = new StringBuilder();
        //前5位
        long firstFiveBitsMask = 0xf800000000000000l;
        long bitsCopy = bits;
        int partialChunks = (int) Math.ceil(((double) significantBits / 5));
        System.out.println(Long.toBinaryString(bits).length());
        for (int i = 0; i < partialChunks; i++) {
            int pointer = (int) ((bitsCopy & firstFiveBitsMask) >>> 59);
            //取最高5位
            System.out.println(Long.toBinaryString((bitsCopy & firstFiveBitsMask)));
//            if(pointer == 31){
//                System.out.println("31!!!!");
//                System.out.println(Long.toBinaryString((bitsCopy & firstFiveBitsMask)>>>59));
//            }
//            System.out.println(pointer);
            buf.append(base32[pointer]);
            bitsCopy <<= 5;
        }
        return buf.toString();
    }
    public String toString() {
        if (significantBits % 5 == 0) {
            return String.format("%s -> %s -> %s", Long.toBinaryString(bits), boundingBox, toBase32());
        } else {
            return String.format("%s -> %s, bits: %d", Long.toBinaryString(bits), boundingBox, significantBits);
        }
    }

//
public static void main(String[] args) {
    GeoHash hash1 = new GeoHash(90,180,10);
//    GeoHash hash2 = new GeoHash(41.390943,-76.9375,10);
//    GeoHash hash3 = new GeoHash(47.390943,-72.9375,10);
    System.out.println(hash1.toBase32());
//    System.out.println(hash1.toString());
//    assert (hash1.toBase32().equals("dr4jb0bn21")):"不等于dr4jb0bn21";
//    System.out.println(hash2.toBase32());
//    System.out.println(hash3.toBase32());
}
}
