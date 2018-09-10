package leetcode;

//  Char. number range  |        UTF-8 octet sequence
//  (hexadecimal)    |              (binary)
//  --------------------+---------------------------------------------
//  0000 0000-0000 007F | 0xxxxxxx
//  0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//  0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//  0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// the first n-bits are all one's, the n+1 bit is 0,
// followed by n-1 bytes with most significant 2 bits being 10.
public class lc393 {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) return false;
            int oneCnt = 0;
            //1000 0000
            if ((data[i] & 128) == 0)
                oneCnt = 1;
                //110 00000  &1110 0000->110
            else if ((data[i] & 224) == 192) {
                oneCnt = 2;
                //110
            } else if ((data[i] & 240) == 224) {
                oneCnt = 3;
                //11110
            } else if ((data[i] & 248) == 240) {
                oneCnt = 4;
            } else {
                return false;
            }
            //第一个之后应该10开头
            for (int j = 1; j < oneCnt; j++) {
                //关键
                if (i + j >= data.length) return false;
                //10
                if ((data[i + j] & 192) != 128) return false;
            }
            //关键
            i = i + oneCnt - 1;
        }
        return true;
    }
}
