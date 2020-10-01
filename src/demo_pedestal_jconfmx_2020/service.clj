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
	[request]
	{:status 200
	 :body (data/create! (get-in request [:path-params :name]) (get-in request [:json-params :power]) (get-in request [:json-params :friends]))})
