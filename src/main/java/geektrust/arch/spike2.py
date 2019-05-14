import csv, sys, json


# credit : movie_id,title,cast,crew

# movies : budget,genres,homepage,id,keywords,original_language,original_title,overview,popularity,
#   production_companies,production_countries,release_date,revenue,runtime,spoken_languages,status,tagline,title,vote_average,vote_count

# user prefs: [user_id: { preferred_languages :[], favorite_actors:[]},..]

def load(name):
    l = []
    with open('/Users/kraghunathan/k/geektrust/'+name, 'r') as f:
        reader = csv.reader(f)
        for row in reader:
            l.append( row)
    return l

movies      = load('movies')
movie_headers = movies.pop(0)

credits     = load('credits')
credits_headers = credits.pop(0)

userprefs   = json.load(open('/Users/kraghunathan/k/geektrust/user_preferences.json'))


def get_director(credits_row):
    crew = json.loads(credits_row[3])
    dir_row = [x for x in crew if  x['job'] == 'Director']
    if dir_row:
        return dir_row[0]['name']
    return ''


def get_actor(credits_row,i):
    cast = json.loads(credits_row[2])
    if cast and len(cast) > i:
        return cast[i]['name']
    else:
        return ''



key_lookup  = {}
director_map = {}
actor1_map  = {}
actor2_map  = {}
actor3_map  = {}
actor4_map  = {}


def put_multi_key(multi_word_key,store,movie_title):
    for i in multi_word_key.strip().split(' '):
        i = i.strip().lower()
        if store.has_key(i):
            l = store[i]
            l.append(movie_title)
        else:
            store[i] = [movie_title]


for i in credits:
    director = get_director(i)
    put_multi_key(director,director_map,i[1])
    actor = get_actor(i,0)
    #actor1_map[actor.strip().lower()] = i[1]
    put_multi_key(actor, actor1_map,i[1])
    actor = get_actor(i,1)
    put_multi_key(actor, actor2_map,i[1])
    actor = get_actor(i,2)
    put_multi_key(actor, actor3_map,i[1])
    actor = get_actor(i,3)
    put_multi_key(actor, actor4_map,i[1])

# print len(director_map)
# for x in director_map:
#     print x
#
# print director_map['thor']
# print director_map['Thor']
searches = [ director_map, actor1_map, actor2_map, actor3_map, actor4_map]
def search(term):
    ret = []
    for i in searches:
        if i.has_key(term):
            ret.append( i[term])
    return ret


print search('spielberg')

# for i in credits:
#     if 'piel' in get_director(i):
#         print i[1]




"""
    director-map  = { director:[movie1,movie2 etc]}
    actorN map    = { actorN :[ [1 movies],[2 movies], 3[movies]}
"""

"""
    search in
        *director_name*,
        *actor_1_name*,
        *actor_2_name*,
        *actor_3_name*
        *movie_title*
    in the movies data
"""

