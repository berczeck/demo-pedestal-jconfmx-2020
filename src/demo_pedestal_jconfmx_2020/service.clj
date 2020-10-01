(ns demo-pedestal-jconfmx-2020.service
	(:require [demo-pedestal-jconfmx-2020.util.data :as data]))

(defn hello-world
	[_]
	{:status 200 :body "Hello, world!"})
