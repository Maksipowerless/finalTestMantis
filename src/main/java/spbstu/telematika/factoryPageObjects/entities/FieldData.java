package spbstu.telematika.factoryPageObjects.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldData {

    String category;
    String reproducibility;
    String severity;
    String priority;
    String platform;
    String os;
    String osVersion;
    String assignTo;
    String summary;
    String description;
    String steptoreproduce;
    String additionalinfo;

    public void setRandomNumbers() {
        int max = 1000;
        int min = 1;

        Random rn = new Random();
        int randInt = rn.nextInt(max - min + 1) + min;
        summary += randInt;
        randInt = rn.nextInt(max - min + 1) + min;
        description += randInt;
        randInt = rn.nextInt(max - min + 1) + min;
        steptoreproduce += randInt;
        randInt = rn.nextInt(max - min + 1) + min;
        additionalinfo += randInt;
    }
}
