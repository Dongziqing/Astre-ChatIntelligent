Feature: Gestion des Chats Intelligents à Travers la Galaxie

  En tant que membre du peuple Félinova,
  Je veux utiliser une technologie de réduction planétaire
  Afin que je puisse voyager librement entre les bases félines sans être détecté par les humains.

  Scenario Outline: Un chat cherche les nouvelle diametre
    Given un planet nommée "<nom>" avec un diamètre de <diametre> KM
    When il fait scale_down
    Then il doit connaître nouvelle diametre <diametre_scale> mm

    Examples:
      | nom       | diametre | diametre_scale     |
      | Soleil    | 1392700   | 220       |

  Scenario: Calculer la proportion entre une planète et une maison de chat
    Given une planète nommée Soleil avec un diamètre de 1392700 km
    And une porte de chat avec une largeur moyenne de 0.22 m
    When je calcule la proportion entre Soleil et la porte de chat
    Then la proportion devrait être environ 6330000000 avec une marge de 10000000