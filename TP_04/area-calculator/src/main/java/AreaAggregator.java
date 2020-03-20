import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
    private List<HasArea> shapes = new ArrayList<>();

    public void addArea(HasArea shape) {
        shapes.add(shape);
    }

    public double sum() {
        double sum = 0;
        for (HasArea shape: shapes) {
            sum+=shape.getArea();
        }
        return sum;
    }


}