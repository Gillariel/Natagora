<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * CountObservationsSessionsUser Entity
 *
 * @property int $Number
 * @property int $Sessions_ID
 * @property int $User_ID
 */
class CountObservationsSessionsUser extends Entity
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
        'Number' => true,
        'Sessions_ID' => true,
        'User_ID' => true
    ];
}
