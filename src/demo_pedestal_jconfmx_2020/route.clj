(ns demo-pedestal-jconfmx-2020.route
	(:require [io.pedestal.http.body-params :as body-params]
						[io.pedestal.http.route :as route]
						[demo-pedestal-jconfmx-2020.service :as service]
						[clojure.string :as str]
						[demo-pedestal-jconfmx-2020.util.content :refer [to->json]]))


;; context {:request {:path-params {:name}}}
;; context {:response {:headers {"Content-Type"} :body}}
(def demo-interceptor
	{:name :demo-interceptor
	 :enter (fn [context]
						(update-in context [:request :path-params :name] #(str/replace % #"%20" "-")))
	 :leave (fn [context]
						(update-in context [:response] to->json))})

(def routes
	(route/expand-routes
		#{["/hello-world" :get [service/hello-world] :route-name :hello-world]
			["/dragon-ball/:name" :get [demo-interceptor service/dragon-ball-view] :route-name :dragon-ball-view]
			["/dragon-ball/:name":post [demo-interceptor (body-params/body-params) service/dragon-ball-create] :route-name :dragon-ball-create]}))
