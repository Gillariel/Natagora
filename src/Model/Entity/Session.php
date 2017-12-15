<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Session Entity
 *
 * @property int $ID
 * @property bool $Validated
 * @property \Cake\I18n\FrozenTime $Date
 * @property float $Latitude
 * @property float $Longitude
 * @property string $Comment
 * @property int $User_ID
 *
 * @property \App\Model\Entity\CountObservation[] $count_observations
 */
class Session extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * Note that when '*' is set to true, this allows all unspecified fields to
     * be mass assigned. For security purposes, it is advised to set '*' to false
     * (or remove it), and explicitly make individual fields accessible as needed.
     *
     * @var array
     */
    protected $_accessible = [
        'Validated' => true,
        'Date' => true,
        'Latitude' => true,
        'Longitude' => true,
        'Comment' => true,
        'User_ID' => true,
        'count_observations' => true
    ];
}
