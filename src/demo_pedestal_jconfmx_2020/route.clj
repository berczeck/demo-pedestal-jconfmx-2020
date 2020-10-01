(ns demo-pedestal-jconfmx-2020.route
	(:require [io.pedestal.http.body-params :as body-params]
						[io.pedestal.http.route :as route]
						[demo-pedestal-jconfmx-2020.service :as service]
						[clojure.string :as str]
						[demo-pedestal-jconfmx-2020.util.content :refer [to->json]]))

;; TODO: Create demo-interceptor, add it to routes

(def routes
	(route/expand-routes
		#{["/hello-world" :get [service/hello-world] :route-name :hello-world]
			["/dragon-ball/:name" :get [service/dragon-ball-view] :route-name :dragon-ball-view]
			["/dragon-ball/:name":post [(body-params/body-params) service/dragon-ball-create] :route-name :dragon-ball-create]}))
