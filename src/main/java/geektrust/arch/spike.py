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

def get_movie_title(credits_row):
    return credits_row[1]

def get_original_language(movies_row):
    return movies_row[5]

def search( user, search_term):
    # user_pref = userprefs[user]
    """
        search in
            *director_name*,
            *actor_1_name*,
            *actor_2_name*,
            *actor_3_name*
            *movie_title*
        in the movies data
    """
    r1 = [x[1] for x in credits if search_term in get_director(x)]
    r2 = [x[1] for x in credits if search_term in get_actor(x,0)]
    r3 = [x[1] for x in credits if search_term in get_actor(x,1)]
    r4 = [x[1] for x in credits if search_term in get_actor(x,2)]
    r5 = [x[1] for x in credits if search_term in get_movie_title(x)]
    l = []
    l.extend(r1)
    l.extend(r2)
    l.extend(r3)
    l.extend(r4)
    l.extend(r5)
    return set(l)

"""
for i in range(1,10):
    print get_movie_title(credits[i]),'(' + get_original_language(movies[i]) + ')'
    print '  ',get_director( credits[i])
    print '\t',get_actor(credits[i],0)
    print '\t',get_actor(credits[i],1)
    print '\t',get_actor(credits[i],2)
    print '\n'
"""

def filter_search(search_results, user_prefs):
    #won't this be done better by order by?
    pass

def test_search():
    a = search('a','Gore')
    for i in a:
        print i



print json.loads(json.l)
