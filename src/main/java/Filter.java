import java.util.*;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(list);
        ListIterator<Integer> iterator = resultList.listIterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element < treshold) {
                logger.log("Элемент " + element + " не проходит");
                iterator.remove();
            }
        }
        int countValid = resultList.size();
        logger.log("Прошло фильтр " + countValid + " элемента из " + list.size());
        return resultList;
    }
}
