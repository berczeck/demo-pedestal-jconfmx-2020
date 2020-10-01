(ns demo-pedestal-jconfmx-2020.util.content
	(:require [clojure.data.json :as json]))

(defn to->json
	[response]
	(-> response
		(update :body json/write-str)
		(assoc-in [:headers "Content-Type"] "application/json")))
