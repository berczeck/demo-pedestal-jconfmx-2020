(ns demo-pedestal-jconfmx-2020.util.data)

(def memory-db
	(atom {:data #{{:name "Goku" :power 500000 :friends ["krilin" "roshi" "vegeta"]}
								 {:name "Freezer" :power 30000 :friends ["dodoria", "sabon"]}
								 {:name "Tenshin-Han" :power 2000 :friends ["goku"]}}}))

(defn read-db [] @memory-db)

(defn write-db [new-db] (reset! memory-db new-db))

(defn create!
	[name power friends]
	(let [character {:name name :power power :friends friends}]
		(write-db (update (read-db) :data conj character))
		character))

(defn read!
	[name]
	(first (filter #(= (:name %) name) (:data (read-db)))))
