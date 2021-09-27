# FetchRewards

## Intro:
Fetch Rewards assignment. Connects to the Fetch API to get some mock data. The data is sorted by Listing ID and then by Name. Null and blank names are removed.

## Structure:
* MVVM Architecture
  * [Model](https://github.com/samyups1111/FetchRewards/tree/main/app/src/main/java/com/sammydj/fetchrewards/model)
  * [View](https://github.com/samyups1111/FetchRewards/tree/main/app/src/main/java/com/sammydj/fetchrewards/ui)
  * [ViewModel](https://github.com/samyups1111/FetchRewards/blob/main/app/src/main/java/com/sammydj/fetchrewards/MainViewModel.kt)

## Libraries:
* [Room Persistance Library](https://github.com/samyups1111/FetchRewards/tree/main/app/src/main/java/com/sammydj/fetchrewards/database)
  * For Caching data retrieved from Network Calls.
* [Retrofit Library](https://github.com/samyups1111/FetchRewards/tree/main/app/src/main/java/com/sammydj/fetchrewards/network)
  * For making Network Calls.
* Coroutine
  * For asynchronous programming.

![screenshot](https://github.com/samyups1111/FetchRewards/blob/main/app/src/main/res/drawable/screenshot.png)
