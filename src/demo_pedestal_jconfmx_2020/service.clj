(ns demo-pedestal-jconfmx-2020.service
	(:require [demo-pedestal-jconfmx-2020.util.data :as data]))

(defn hello-world
	[_]
	{:status 200 :body "Hello, world!"})

;; request {:path-params {:name}}
(defn dragon-ball-view
	[request]
	{:status 200 :body (data/read! (:name (:path-params request)))})

;; request {:path-params {:name} :json-params {:power :friends}}
(defn dragon-ball-create
	[{:keys [json-params path-params]}]
	(let [name    (:name path-params)
				power   (:power json-params)
				friends (:friends json-params)]
		{:status 200
		 :body   (data/create! name power friends)}))
