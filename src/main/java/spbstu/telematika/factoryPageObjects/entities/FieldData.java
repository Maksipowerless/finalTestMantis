package spbstu.telematika.factoryPageObjects.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.flotsam.xeger.Xeger;

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

    public void setRandomStrings()
    {
        Xeger generation = new Xeger(platform);
        platform = generation.generate();

        generation = new Xeger(os);
        os = generation.generate();

        generation = new Xeger(osVersion);
        osVersion = generation.generate();

        generation = new Xeger(summary);
        summary = generation.generate();

        generation = new Xeger(description);
        description = generation.generate();

        generation = new Xeger(steptoreproduce);
        steptoreproduce = generation.generate();

        generation = new Xeger(additionalinfo);
        additionalinfo = generation.generate();
    }
}
