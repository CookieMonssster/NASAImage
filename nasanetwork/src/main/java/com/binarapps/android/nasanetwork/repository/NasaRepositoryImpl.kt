package com.binarapps.android.nasanetwork.repository

import com.binarapps.android.nasanetwork.model.NasaImage
import io.reactivex.Single

class NasaRepositoryImpl : NasaRepository {

    override fun getNasaImage(query: String): Single<List<NasaImage>> {
        //TODO add implementataion
        return Single.just(
            listOf(
                NasaImage(
                    "Saturn Apollo Program",
                    "The crowning achievement for the Saturn V rocket came when it launched Apollo 11 astronauts, Neil Armstrong, Edwin (Buzz) Aldrin, and Michael Collins, to the Moon in July 1969. In this photograph, astronaut Aldrin takes his first step onto the surface of the Moon.",
                    "1969-07-01",
                    "images-assets.nasa.gov/image/6900937/6900937~orig.jpg"
                ),
                NasaImage(
                    "Apollo 12 Mission",
                    "AS12-46-6790 (19 Nov. 1969) --- Astronaut Alan L. Bean, lunar module pilot, is photographed at quadrant II of the Lunar Module (LM) during the first Apollo 12 extravehicular activity (EVA) on the moon. This picture was taken by astronaut Charles Conrad Jr., commander. Here, Bean is using a fuel transfer tool to remove the fuel element from the fuel cask mounted on the LM's descent stage. The fuel element was then placed in the Radioisotope Thermoelectric Generator (RTG), the power source for the Apollo Lunar Surface Experiments Package (ALSEP) which was deployed on the moon by the two astronauts. The RTG is next to Bean's right leg. While astronauts Conrad and Bean descended in the LM \"Intrepid\" to explore the Ocean of Storms region of the moon, astronaut Richard F. Gordon Jr., command module pilot, remained with the Command and Service Modules (CSM) \"Yankee Clipper\" in lunar orbit.",
                    "1969-11-19",
                    "images-assets.nasa.gov/image/as12-46-6790/as12-46-6790~orig.jpg"
                ),
                NasaImage(
                    "View - Replica - Plaque - Moon - Apollo XVI Crew",
                    "S89-36956 (16 June 1989) --- A replica of the plaque left on the moon by the Apollo 16 crew.",
                    "1989-06-16",
                    "images-assets.nasa.gov/image/S89-36956/S89-36956~orig.jpg"
                ),
                NasaImage(
                    "Full Moon",
                    "Full Moon. Rises at sunset, high in the sky around midnight. Visible all night. This marks the first time that accurate shadows at this level of detail are possible in such a computer simulation. The shadows are based on the global elevation map being developed from measurements by the Lunar Orbiter Laser Altimeter (LOLA) aboard the Lunar Reconnaissance Orbiter (LRO). LOLA has already taken more than 10 times as many elevation measurements as all previous missions combined. ",
                    "12/8/2017",
                    "images-assets.nasa.gov/image/GSFC_20171208_Archive_e001861/GSFC_20171208_Archive_e001861~orig.jpg"
                ),
                NasaImage(
                    "Harvest Moon at NASA Goddard",
                    "September's Harvest Moon as seen around NASA's Goddard Space Flight Center. According to folklore, every full Moon has a special name. There's the Wolf Moon, the Snow Moon, the Worm Moon, the Sprouting Grass Moon, the Flower Moon, the Strawberry Moon, the Thunder Moon, the Sturgeon Moon, the Harvest Moon, the Hunter's Moon, the Beaver Moon, and the Long Night's Moon. Each name tells us something about the season or month in which the full Moon appears. ",
                    "12/8/2017",
                    "images-assets.nasa.gov/image/GSFC_20171208_Archive_e001380/GSFC_20171208_Archive_e001380~orig.jpg"
                ),
                NasaImage(
                    "Turning on Mars",
                    "Turning on Mars",
                    "2004-01-13",
                    "images-assets.nasa.gov/image/PIA05054/PIA05054~orig.jpg"
                ),
                NasaImage(
                    "Mars at Ls 25°: Tharsis",
                    "Mars at Ls 25°: Tharsis",
                    "2006-03-07",
                    "images-assets.nasa.gov/image/PIA02697/PIA02697~orig.jpg"
                ),
                NasaImage(
                    "Frost on Mars",
                    "Frost on Mars",
                    "2008-10-09",
                    "images-assets.nasa.gov/image/PIA11132/PIA11132~orig.jpg"
                )
            )
        )
    }
}