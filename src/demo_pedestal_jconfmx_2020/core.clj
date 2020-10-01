(ns demo-pedestal-jconfmx-2020.core
  (:require [io.pedestal.http :as http]
            [demo-pedestal-jconfmx-2020.route :as route])
  (:gen-class))

(def service
  {::http/type :jetty
   ::http/routes route/routes
   ::http/port 9080})

(defn create-server
  []
  (http/create-server service))

(defn start-server
  []
  (http/start (create-server)))

(defn -main
  [& args]
  (start-server))
