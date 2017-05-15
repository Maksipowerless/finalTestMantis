package spbstu.telematika.factoryPageObjects.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by maxfromperek on 16.04.17.
 */

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
}
