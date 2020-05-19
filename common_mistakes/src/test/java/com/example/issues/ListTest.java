package com.example.issues;

import com.example.common.mistakes.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:21 on 2020/3/31
 * @version V0.1
 * @classNmae ListTest
 */
@Slf4j
public class ListTest {


    private static Object listSearch(int elementCount, int loopCount) {
        List<Item> list = IntStream.rangeClosed(1, elementCount).mapToObj(i -> new Item(i)).collect(Collectors.toList());
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Item result = list.stream().filter(item -> item.getItemId() == search).findFirst().orElse(null);
            Assert.assertTrue(result != null && result.getItemId() == search);
        });
        return list;
    }

    private static Object mapSearch(int elementCount, int loopCount) {
        Map map = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toMap(Function.identity(), i -> new Item(i)));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Item result = (Item) map.get(search);
            Assert.assertTrue(result != null && result.getItemId() == search);
        });
        return map;
    }

    @Test
    public void listVsMap() {

        int elementCount = 1000000;
        int loopCount = 1000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("listSearch");
        Object list = listSearch(elementCount, loopCount);
//        System.out.println(ObjectSizeCalculator.getObjectSize(list));
        stopWatch.stop();
        stopWatch.start("mapSearch");
        Object map = mapSearch(elementCount, loopCount);
        stopWatch.stop();
//        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(stopWatch.prettyPrint());

    }

    @Test
    public void asListTest() {

        //不能直接使用 Arrays.asList 来转换基本类型数组
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());

        Integer[] arr2 = {1, 2, 3};
        List list2 = Arrays.asList(arr2);
        log.info("list2:{} size:{} class:{}", arr2, list2.size(), list2.get(0).getClass());
    }

    @Test
    public void asListTest_2() {

        String[] arr3 = {"1", "2", "3"};
        //对原始数组的修改会影响到我们获得的那个 List
        List list3 = Arrays.asList(arr3);
        arr3[1] = "4";
        try {
            //Arrays.asList 返回的 List 不支持增删操作
            list3.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("arr:{} list:{}", Arrays.toString(arr3), list3);

    }

    @Test
    public void subListTest() {

        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
    }

    @Test
    public void subListTest2() {

        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        //错误示范
//        List<Integer> subList = list.subList(1, 4);

        //方式一：
//        List<Integer> subList = new ArrayList<>(list.subList(1, 4));

//方式二：
        List<Integer> subList = list.stream().skip(1).limit(3).collect(Collectors.toList());
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {

            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    //LinkedList访问
    private static void linkedListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    //ArrayList访问
    private static void arrayListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    //LinkedList插入
    private static void linkedListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount),1));
    }

    //ArrayList插入
    private static void arrayListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount),1));
    }

    @Test
    public void linkVsArrayList(){

        int elementCount = 100000;
        int loopCount = 100000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("linkedListGet");
        linkedListGet(elementCount, loopCount);
        stopWatch.stop();
        stopWatch.start("arrayListGet");
        arrayListGet(elementCount, loopCount);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());


        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start("linkedListAdd");
        linkedListAdd(elementCount, loopCount);
        stopWatch2.stop();
        stopWatch2.start("arrayListAdd");
        arrayListAdd(elementCount, loopCount);
        stopWatch2.stop();
        System.out.println(stopWatch2.prettyPrint());
    }

    @Test
    public void listRemove(){
        Integer[] array = {1, 2, 3};
        List list2 =new ArrayList(Arrays.asList(array)) ;
        log.info("list2:{} size:{} class:{}", array, list2.size(), list2.get(0).getClass());
//        list2.remove(2);
        //foreach 遍历删除元素 抛 ConcurrentModificationException
//        for (Object i:list2 ) {
//            list2.remove(i);
//        }
        //解决方案
        Iterator it = list2.iterator();
        while (it.hasNext()){
            Object next = it.next();
            if(next.equals(1)){
                it.remove();
            }

        }
//        log.info("list2:{} size:{}", array, list2.size());
    }
}
