package cache;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author zhangxinpeng
 * @date 2020/3/23
 */
public class CacheBloomFilterTest {
    private static int size = 500;
    private static BloomFilter<Integer> demoFilter = BloomFilter.create(Funnels.integerFunnel(), size);

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            demoFilter.put(i);
        }

        if(demoFilter.mightContain(23)) {
            System.out.println("Found it!");
        }
    }
}
