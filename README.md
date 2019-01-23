# LiveBattery

![Android](https://img.shields.io/badge/platform-Android-brightgreen.svg)
![Apache](https://img.shields.io/github/license/samelody/livebattery.svg)
![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg)
[![Bintray](https://api.bintray.com/packages/belinwu/maven/livebattery/images/download.svg)](https://bintray.com/belinwu/maven/livebattery/_latestVersion)

A LiveData for monitoring Android battery.

**DO NOT USE THIS LIBRARY IN PRODUCTION UNTIL V1.0.0 IS RELEASED.**

# Installation

Add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.samelody.livebattery:livebattery:0.1.0'
}
```

# Usage

In your Activity/Fragment/Service, create and observe a BatteryLiveData.

## Java

```java
liveBattery = new BatteryLiveData(this);
liveBattery.observe(this, new Observer<BatteryInfo>() {
    @Override
    public void onChanged(BatteryInfo info) {
        Log.d("BatteryInfo", "BatteryInfo=" + info);
    }
});
```

## Kotlin

```kotlin
liveBattery = BatteryLiveData(this)
liveBattery.observe(this, Observer {
    println(it)
})
```

# Docs

## BatteryInfo

BatteryInfo is the data in a BatteryLiveData, it has following properties:

```java
// The current battery status.
private int status;

// The current battery health.
private int health;

// The current battery plugged mode.
private int plugged;

// The current battery level.
private int level;

// The maximum battery level.
private int scale;

// The current battery temperature.
private int temperature;

// The current battery voltage.
private int voltage;
```

Get the remaining battery percent using `BatteryInfo#getPercent()` method.

# Dependencies

`androidx.lifecycle:lifecycle-livedata-core:2.0.0`

# Thanks

[RxBattery](https://github.com/pwittchen/RxBattery)

# License

```
Copyright 2019 Samelody.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```