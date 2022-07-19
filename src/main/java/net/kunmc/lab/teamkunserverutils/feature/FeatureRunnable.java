package net.kunmc.lab.teamkunserverutils.feature;

import java.util.List;
import javax.annotation.Nullable;

@FunctionalInterface
public interface FeatureRunnable {

  ResultBuilder run(@Nullable List<Object> args);
}
