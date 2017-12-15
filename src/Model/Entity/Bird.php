<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Bird Entity
 *
 * @property int $ID
 * @property string $Name
 * @property int $Length
 * @property int $Weight
 * @property \Cake\I18n\FrozenTime $Creation_Date
 *
 * @property \App\Model\Entity\Observation[] $observation
 */
class Bird extends Entity
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
        'Name' => true,
        'Length' => true,
        'Weight' => true,
        'Creation_Date' => true,
        'observation' => true
    ];
}
