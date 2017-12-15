<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Media Entity
 *
 * @property int $ID
 * @property string $Name
 * @property string $Url
 * @property string $Text
 * @property int $Validated
 * @property int $Deleted
 * @property int $Has_Been_Pended
 * @property \Cake\I18n\FrozenTime $Creation_Date
 * @property int $MediaType_ID
 * @property int $Observation_ID
 */
class Media extends Entity
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
        'Url' => true,
        'Text' => true,
        'Validated' => true,
        'Deleted' => true,
        'Has_Been_Pended' => true,
        'Creation_Date' => true,
        'MediaType_ID' => true,
        'Observation_ID' => true
    ];
}
