package organism;

import lombok.Getter;

@Getter
public class Plants extends Organism {
    // хар-ки растений
    private static final double maxWeight = 1;
    @Getter
    private static final int maxCount = 200;


    public Plants() {
        super(1.0);
    }

}
