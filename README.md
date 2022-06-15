Gatling performance tests for my [localstack](https://github.com/slawekradzyminski/awesome-localstack)

## Running

```commandline
mvn gatling:test -Dgatling.simulationClass=com.awesome.testing.BasicSimulation
```

## User cleanup

```commandline
mvn gatling:test -Dgatling.simulationClass=com.awesome.testing.CleanupSimulation
```

## Example calculation

```scala
val skuQueriesPerHour = 26400
val usersPerSecond = EnvConfig.noOfSites * skuQueriesPerHour / minutesInHour / secondsInMinute

skuScenario.inject(
        rampUsersPerSec(0) to usersPerSecond during 60.minutes,
        constantUsersPerSec(usersPerSecond) during 60.minutes randomized
      )
```

## Good resources

[Gatling complete guide](https://www.james-willett.com/gatling-load-testing-complete-guide/)