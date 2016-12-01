package leetcode;
/* Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
 * 
 */
import java.util.*;
public class lc_379_designPhoneDirectory {
Set<Integer> phone;
    
    public lc_379_designPhoneDirectory(int maxNumbers) {
        phone = new HashSet<Integer>();
        for (int i = 0; i < maxNumbers; i ++){
            phone.add(i);
        }
    }
    
    public int get() {
        int result = -1;
        if (phone.size() <= 0){
            return result;
        }else{
            for (int temp: phone){
                result = temp;
                break;
            }
            phone.remove(result);
            return result;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return phone.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        phone.add(number);
    }
}
