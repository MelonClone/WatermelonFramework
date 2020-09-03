# Watermelon Framework

## Usage

### Build source tree

```
java
└ [packages]
  └ domain
    └ [domain_name]
      └ dao
        └ [daos] // for DAO
      └ domain
        └ [domain_items]
      └ model
        └ [data_source] // for DAO executor
        └ [models] // for DB & SharedPreference
        └ [repositories] // for http
      └ view
        └ activity
          └ [activities] // Context, AppcompatActivity
        └ adapter
          └ [adapters] // for RecyclerView.Adapter etc.
        └ fragment
          └ [views] // View, Fragment
      └ viewmodel
        └ [view_models] // ViewModel
  └ global
  └ utils
```

##

```
java
└ org.watermelon.framework
  └ global
    └ consts
      └ [constants] // Constant Variables, Presets
    └ customview
      └ [views] // custom views
    └ db
      └ AppDatabase.java // SQLite Database initiate
      └ version
        └ [migrations] // SQLs for version migrate
    └ media
      └ control
        └ [Controls] // for control each Players
      └ listener
        └ [PlayerListeners] // Playing listeners
      └ player
        └ [MusicPlayers] // Player Implements (concrete class)
      └ PlayManager.java // Player central manager
    └ model
      └ BaseApplication.java
      └ dao
        └ [DAOs] // Database DAOs
      └ domain
        └ [Base Domain] // Domain bases
      └ handler
        └ [TabMenu] // Tab builder
      └ repository
        └ Repository // Network callback
      └ view
        └ activity
          └ [Base activity] // Base activity and interfaces
        └ adapter
          └ [Base adapters] // Base adapters
        └ fragment
          └ [Base Views] // Base fragments, views
        └ states
          └ [states] // for View's states
      └ viewmodel
        └ [Base ViewModel] // Base view models
  └ utils
    └ db
    └ file
    └ image
    └ jwt
    └ network
    └ store
    └ view
    └ [ETC Utils]


```