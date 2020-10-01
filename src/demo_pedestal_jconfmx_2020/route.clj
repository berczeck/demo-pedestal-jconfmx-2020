(ns demo-pedestal-jconfmx-2020.route
	(:require [io.pedestal.http.body-params :as body-params]
						[io.pedestal.http.route :as route]
						[demo-pedestal-jconfmx-2020.service :as service]
						[clojure.string :as str]
						[demo-pedestal-jconfmx-2020.util.content :refer [to->json]]))

;; TODO: Create hello-world route GET "/hello-world" & handler
;; TODO: Create dragon-ball-view route GET "/dragon-ball/:name" & read handler
;; TODO: Create dragon-ball-create route POST "/dragon-ball/:name" & create handler (using get)
;; TODO: Refactor create handler using let (path-params json-params)
;; TODO: Refactor create handler using destructuring {:keys [json-params path-params]}
;; TODO: Create demo-interceptor, add it to routes

(def routes
	(route/expand-routes
		#{["/hello-world" :get [service/hello-world] :route-name :hello-world]}))
